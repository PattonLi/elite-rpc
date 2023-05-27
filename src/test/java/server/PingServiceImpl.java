package server;

import org.example.IDL.Ping.PingRequest;
import org.example.IDL.Ping.PingResponse;
import org.example.IDL.Ping.PingService;

public class PingServiceImpl implements PingService {

    @Override
    public PingResponse ping(PingRequest request) {
        String name = request.getName();
        String retMsg = "pong: " + name;
        PingResponse response = new PingResponse(retMsg);
        return response;
    }
}
