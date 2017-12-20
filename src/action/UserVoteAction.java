package action;

import java.rmi.RemoteException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.LoginBean;
import uc.sd.apis.FacebookApi2;

public class UserVoteAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	private String votevalue;
	
	private static final String PROTECTED_RESOURCE_URL_POST = "https://graph.facebook.com/v2.11/me/feed";
	private static final String API_APP_KEY = "967369783407588";
    private static final String API_APP_SECRET = "e465f74c61ec82228ab818cdb4b2147e";
	

	@Override
	public String execute() 
	{	
		
		this.getLoginBean().setVotevalue(votevalue);
		
		try {
			if(!this.getLoginBean().vote())
				return ERROR;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (this.session.get("fbloggedin").equals("true"))
		{
			OAuthService service = new ServiceBuilder()
	                .provider(FacebookApi2.class)
	                .apiKey(API_APP_KEY)
	                .apiSecret(API_APP_SECRET)
	                .scope("publish_actions")
	                .build();
			
			Token accessToken = (Token) session.get("accessToken");
			
			StringBuffer url;
			HttpServletRequest servletRequest = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			url = servletRequest.getRequestURL();
			
			OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL_POST, service);
			request.addBodyParameter("message", "O utilizador " + this.session.get("username") + " acabou de votar!"+"\n"+url.toString());
	        service.signRequest(accessToken,request);
	       
	        Response response = request.send();
	        System.out.println(response.getBody());
			System.out.println(response.getCode());
		}
		
		return SUCCESS;
	}
	
	public LoginBean getLoginBean() {
		if(!session.containsKey("heyBean"))
			this.setLoginBean(new LoginBean());
		return (LoginBean) session.get("heyBean");
	}

	public void setLoginBean(LoginBean heyBean) {
		this.session.put("heyBean", heyBean);
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

	public String getVotevalue() {
		return votevalue;
	}

	public void setVotevalue(String votevalue) {
		this.votevalue = votevalue;
	}

}