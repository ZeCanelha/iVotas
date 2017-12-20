package action;
import com.github.scribejava.core.builder.ServiceBuilder;
import model.FacebookBean;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;

import uc.sd.apis.FacebookApi2;

import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;


public class FacebookRemoveAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	//private static final String NETWORK_NAME = "Facebook";
	private static final String PROTECTED_RESOURCE_URL_DELETE = "https://graph.facebook.com/v2.11";
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
                .scope("publish_actions")
                .build();
	    
	   
	   try {
		HashMap<String,String> map = this.getFaceBean().getFacebookCredentials(this.session.get("userid").toString());
		
		//Só da pra remover o facebook caso esteja logado no facebook; não dá pra obter o token a partir da bd;
		
		Token accessToken = (Token) session.get("accessToken");
		

		String str = PROTECTED_RESOURCE_URL_DELETE + "/"+map.get("facebookid")+"/permissions";
		System.out.println(str.toString());
		
		OAuthRequest request = new OAuthRequest(Verb.DELETE, str, service);
        service.signRequest(accessToken,request);
       
        Response response = request.send();
        System.out.println(response.getBody());
		System.out.println(response.getCode());
		//Remover facebook e merdas da bd
        if (response.getCode() == 200)
        {
        		this.getFaceBean().removeFacebookInformation(this.session.get("userid").toString());
        		return LOGIN;
        }
		
		
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   return ERROR;
		
        
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
		
	}
	public FacebookBean getFaceBean() {
		if(!session.containsKey("faceBean"))
			this.setFacebookBean(new FacebookBean());
		return (FacebookBean) session.get("faceBean");
	}

	public void setFacebookBean(FacebookBean faceBean) {
		this.session.put("faceBean", faceBean);
	}
	
}