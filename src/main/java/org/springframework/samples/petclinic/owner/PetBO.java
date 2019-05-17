package org.springframework.samples.petclinic.owner;

import com.petclinic.springpetclinicsoap.gen.GetOwnerPetsResponse;
import com.petclinic.springpetclinicsoap.gen.GetPetsByOwnerRequest;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;

public class PetBO extends WebServiceGatewaySupport {

    public int invokeWebService(int ownerId)  {
        try {
            GetPetsByOwnerRequest getPetsByOwnerRequest = new GetPetsByOwnerRequest();
            getPetsByOwnerRequest.setOwnerid(ownerId);


           SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(
                MessageFactory.newInstance());
            messageFactory.afterPropertiesSet();

            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(
                messageFactory);
            Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

            marshaller.setContextPath("com.petclinic.springpetclinicsoap.gen");
            marshaller.afterPropertiesSet();

            webServiceTemplate.setMarshaller(marshaller);
            webServiceTemplate.setUnmarshaller((Unmarshaller)marshaller);

            GetOwnerPetsResponse getOwnerPetsResponse=(GetOwnerPetsResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws", getPetsByOwnerRequest);

       return getOwnerPetsResponse.getPet().size();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  0;
    }

}
