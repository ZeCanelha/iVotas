package action;
import com.github.scribejava.core.builder.ServiceBuilder;

import model.LoginBean;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;

import com.opensymphony.xwork2.ActionSupport;

import uc.sd.apis.FacebookApi2;


import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.rmi.RemoteException;
import java.util.Map;




public class ShareElectionAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	//private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL_POST = "https://graph.facebook.com/v2.11/me/feed";
	private static final String API_APP_KEY = "967369783407588";
    private static final String API_APP_SECRET = "e465f74c61ec82228ab818cdb4b2147e";
    private String postid;
    
   

	@Override
	public String execute() 
	{
	    
		
		if (this.session.get("fbloggedin").equals("true"))
		{
			
			OAuthService service = new ServiceBuilder()
	                .provider(FacebookApi2.class)
	                .apiKey(API_APP_KEY)
	                .apiSecret(API_APP_SECRET)
	                .scope("publish_actions")
	                .build();
			
			Token accessToken = (Token) session.get("accessToken");
			
			String url = "http://localhost:8080/iVotas/escolheeleicao.action?electionid="+this.getLoginBean().getElectionid();
			
			OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL_POST, service);
			request.addBodyParameter("message", "Apelo ao voto!\n Durante as eleições não se esqueça de votar! Marque a diferença.\n" + url);
	        service.signRequest(accessToken,request);
	       
	        Response response = request.send();
	        
	        if(response.getCode() == 200)
	        {
	        		System.out.println(response.getBody());
				System.out.println(response.getCode());
				
				this.setPostid(response.getBody());
				try {
					this.getLoginBean().setPostId(this.postid);
					this.getLoginBean().startFacebookThread(accessToken.getToken(), this.postid, this.getLoginBean().getElectionid());
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
				/*TODO: Iniciar a thread ?? */
				/* Passar o election id para dar bom link no post 
				*/
				
				
	        		return SUCCESS;
	        }	
		}
		
		
		return ERROR;
		
		
        
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
		
	}
	
	public LoginBean getLoginBean()
	{
		return (LoginBean) session.get("heyBean");
	}
	
	
	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(postid);
			this.postid = (String) json.get("id");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}