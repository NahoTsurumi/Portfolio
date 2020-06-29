package servise;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import dto.UserInfo;

@WebFilter("/BoardServlet")
public class BasicAu implements Filter {


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ServletRequestとServletResponseをHttp*にキャストする
        HttpServletRequest hreq = (HttpServletRequest)request;
        HttpServletResponse hres = (HttpServletResponse)response;

        // セッション変数を調べて承認済みでない場合(=null)は以下の処理を行う
        HttpSession session = hreq.getSession();

        if (session.getAttribute("USER_INFO") == null) {
            // Authorizationヘッダを取得する
            String auth = hreq.getHeader("Authorization");

            if (auth == null) {
                // 未承認でAuthorizationヘッダがない場合は認証を行うように要求する
                requireAuth(hres);
                return;

            } else {
                try {
                    // 未承認でAuthorizationヘッダがある場合はヘッダの内容を
                    // デコードして入力されたユーザー名とパスワードを取得する
                    String decoded = decodeAuthHeader(auth);

                    // ユーザー名とパスワードを分離
                    int pos = decoded.indexOf(":");
                    String username = decoded.substring(0, pos);
                    String password = decoded.substring(pos + 1);

                    // 認証処理
                    UserInfo user = authenticateUser(username, password);

                    if (user.userId == null || user.userId.equals("")) {
                        // ユーザー名がNULLの場合は認証に失敗したとみなして
                        // 再度認証を行うように要求する
                        requireAuth(hres);
                        return;

                    } else {
                        // UserInfoをセッション変数に保存する
                        session.setAttribute("USER_INFO", user);
                    }

                } catch(Exception ex) {
                    // 失敗したら再度認証を行うように要求する
                    requireAuth(hres);
                    return;

                }
            }

        }

        chain.doFilter(request, response);
	}

	private void requireAuth(HttpServletResponse hres) throws IOException {
        // 認証が成功していない場合は「WWW-Authenticate」ヘッダを付加する
        hres.setHeader("WWW-Authenticate", "BASIC realm=\"Authentication Test\"");
        // 応答をクリアして401(UNAUTHORIZED)を設定する
        hres.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
	
	private String decodeAuthHeader(String header) {
        String ret = "";

        try {
            // 「Basic 」以降の文字列を抽出
            String encStr = header.substring(6);

            // BASE64をデコードする（sun.misc.BASE64Decoderを使用）
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] dec = decoder.decode(encStr);
            // Authorizationヘッダの内容をデコードしたものを代入
            ret = new String(dec);

        } catch(Exception ex) {
            ret = "";
        }

        return ret;
    }

	
	private UserInfo authenticateUser(String username, String password) {
        // ユーザー情報を保存するクラス(後述)のインスタンスを作成
        UserInfo u = new UserInfo();

        // 認証処理
        if (username.equals("cosme") && password.equals("4444")) {
            // ユーザー名とパスワードを設定
            u.userId = username;
            u.password = password;
            // ユーザーに割り当てるロールを作成
            u.roles = new String[] {"Users"};
        }

        return u;
    }
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
