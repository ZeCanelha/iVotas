package action;


import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import java.util.Map;


import model.FacebookBean;
import uc.sd.apis.FacebookApi2;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class FacebookCallbackAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	private static final Token EMPTY_TOKEN = null;
	private static final String API_APP_KEY = "967369783407588";
    private static final String API_APP_SECRET = "e465f74c61ec82228ab818cdb4b2147e";
    
    public String authorizationUrl;
    
    
	@Override
	public String execute() 
	{
	    OAuthService service = new ServiceBuilder()
                .provider(FacebookApi2.class)
                .apiKey(API_APP_KEY)
                .apiSecret(API_APP_SECRET)
                .callback("http://localhost:8080/iVotas/callback") // Do not change this.
                .scope("publish_actions")
                .build();
	    
	    
	    HttpServletRequest servletRequest = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	    
        String code = servletRequest.getParameter("code");
        
        System.out.println(code);
        
        Verifier verifier = new Verifier(code);
         
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        
       
        service.signRequest(accessToken, request);
        
        Response response = request.send();
        
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getCode());
        System.out.println(response.getBody());
	    
        return SUCCESS;
		
        
	}
	
	public FacebookBean getFaceBean() {
		return (FacebookBean) session.get("faceBean");
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}