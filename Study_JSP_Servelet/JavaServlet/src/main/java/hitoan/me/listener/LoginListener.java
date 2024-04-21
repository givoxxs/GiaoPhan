package hitoan.me.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

import org.apache.catalina.User;

// use the @WebListener annotation to declare that this class is a listener
@WebListener
public class LoginListener implements HttpSessionIdListener, HttpSessionAttributeListener{
	public static int onlineUsers = 0;
	// sessionCreated and sessionDestroyed are called when a session is created and destroyed
	public void sessionCreated(HttpSessionEvent event) {
		onlineUsers++;
		System.out.println("--Online Users: " + onlineUsers);
	}

	public void sessionDetroyed(HttpSessionEvent event) {
        onlineUsers--;
        System.out.println("--Online Users: " + onlineUsers);
    }
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getName().equals("username")) {
			User user = (User) arg0.getValue();
			System.out.println("User " + user.getUsername() + " logged in");
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionIdChanged(HttpSessionEvent arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

}
