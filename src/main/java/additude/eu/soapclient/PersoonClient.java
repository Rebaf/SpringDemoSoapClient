package additude.eu.soapclient;

import eu.additude.consumingwebservice.wsdl.GetPersoonRequest;
import eu.additude.consumingwebservice.wsdl.GetPersoonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PersoonClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PersoonClient.class);

    public GetPersoonResponse getPersoon(Long id) {

        GetPersoonRequest request = new GetPersoonRequest();
        request.setId(id);

        log.info("GetPersoonRequest voor id: " + id);

        GetPersoonResponse response = (GetPersoonResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8090/personenSoapWS/personenSoap", request,
                        new SoapActionCallback(
                                "http://additude.eu/guides/gs-producing-web-service/GetPersoonRequest"));

        return response;
    }

}