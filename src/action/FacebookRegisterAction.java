package action;
import com.github.scribejava.core.builder.ServiceBuilder;
import model.FacebookBean;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;

import uc.sd.apis.FacebookApi2;

import org.apache.struts2.interceptor.SessionAware;


import java.util.Map;


public class FacebookRegisterAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	//private static final String NETWORK_NAME = "Facebook";
	//private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
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
                .callback("http://localhost:8080/iVotas/callbackregisto") // Do not change this.
                .scope("publish_actions")
                .build();
	    
	    authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
	    
	    this.getFaceBean().setAuthorizationUrl(authorizationUrl);
	    
	    
        return SUCCESS;
		
        
	}
	
	public FacebookBean getFaceBean() {
		if(!session.containsKey("faceBean"))
			this.setFacebookBean(new FacebookBean());
		return (FacebookBean) session.get("faceBean");
	}

	public void setFacebookBean(FacebookBean faceBean) {
		this.session.put("faceBean", faceBean);
	}
	

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getAuthorizationUrl() {
		return authorizationUrl;
	}


	public void setAuthorizationUrl(String authorizationUrl) {
		this.authorizationUrl = authorizationUrl;
	}
}