package action;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;

import uc.sd.apis.FacebookApi2;

import org.apache.struts2.interceptor.SessionAware;


import java.util.Map;
import java.util.Scanner;

public class FacebookLoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	private static final Token EMPTY_TOKEN = null;
	private static final String API_APP_KEY = "967369783407588";
    private static final String API_APP_SECRET = "e465f74c61ec82228ab818cdb4b2147e";


	@Override
	public String execute() 
	{
	    
	    OAuthService service = new ServiceBuilder()
                .provider(FacebookApi2.class)
                .apiKey(API_APP_KEY)
                .apiSecret(API_APP_SECRET)
                .callback("http://eden.dei.uc.pt/~fmduarte/echo.php") // Do not change this.
                .scope("publish_actions")
                .build();
	    
	    Scanner in = new Scanner(System.in);

	    System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
	    System.out.println();

	    // Obtain the Authorization URL
	    System.out.println("Fetching the Authorization URL...");
	    String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
	    System.out.println("Got the Authorization URL!");
	    System.out.println("Now go and authorize Scribe here:");
	    System.out.println(authorizationUrl);
	    
	    session.put("redirecturl", authorizationUrl);
	    
	    
        return SUCCESS;
		
        
	}
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}