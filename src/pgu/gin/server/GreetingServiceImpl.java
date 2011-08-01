package pgu.gin.server;

import pgu.gin.client.GreetingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

    @Override
    public String greetServer(final String input) throws IllegalArgumentException {
        return input + " OK!";
    }

}
