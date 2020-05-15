package com.example.systemevents;
import com.example.systemevents.PetFriend.Request;
import com.example.systemevents.PetFriend.Response;
import com.example.systemevents.database.Action;
import com.example.systemevents.database.ActionRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;

public class SystemEventsService extends SystemEventsGrpc.SystemEventsImplBase {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public void logAction(Request request, StreamObserver<Response> responseObserver) {
        StringBuilder Odgovor = new StringBuilder()
                .append("Vrijeme:" + request.getTimeStampAkcije())
                .append("Naziv mikroservisa: " + request.getNazivMikroservisa())
                .append("\n")
                .append("Tip akcije: " + request.getAkcija())
                .append("\n")
                .append("Naziv resursa: " + request.getNazivResursa())
                .append("\n");

        Response response = Response.newBuilder()
                .setPorukaOdgovora(Odgovor.toString())
                .build();

        Action zapis = new Action(request.getNazivMikroservisa(),request.getKorisnik(),request.getAkcija(),response.getPorukaOdgovora());
        actionRepository.save(zapis);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
