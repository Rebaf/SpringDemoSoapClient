package additude.eu.soapclient;

import eu.additude.consumingwebservice.wsdl.GetPersoonRequest;
import eu.additude.consumingwebservice.wsdl.GetPersoonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class PersoonClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PersoonClient.class);
    private static final String URI = "http://localhost:8090/personenSoapWS/personenSoap";

    public GetPersoonResponse getPersoon(Long id) {

        GetPersoonRequest request = new GetPersoonRequest();
        request.setId(id);

        log.info("GetPersoonRequest voor id: " + id);

        return  (GetPersoonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(URI, request);
    }

}