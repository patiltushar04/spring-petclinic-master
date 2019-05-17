package org.springframework.samples.petclinic.owner;

import com.petclinic.springpetclinicsoap.gen.GetOwnerPetsResponse;
import com.petclinic.springpetclinicsoap.gen.GetPetsByOwnerRequest;
import com.sun.org.apache.xerces.internal.jaxp.datatype.DatatypeFactoryImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeFactory;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Endpoint
public class PetEndpoint {

    private static final String NAMESPACE_URI = "http://www.petclinic.com/springpetclinicsoap/gen";
    @Autowired
    private  PetRepository pets;
    @Autowired
    private OwnerRepository owners;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPetsByOwnerRequest")
    @ResponsePayload
    public GetOwnerPetsResponse getPetsByOwner(@RequestPayload GetPetsByOwnerRequest getPetsByOwnerRequest){
        GetOwnerPetsResponse getOwnerPetsResponse=new GetOwnerPetsResponse();
        List<Pet> pets= this.owners.findById(getPetsByOwnerRequest.getOwnerid()).getPets();
        List<GetOwnerPetsResponse.Pet> pets1=new ArrayList<>();
        pets1=pets.stream().map(p->{
            GetOwnerPetsResponse.Pet pet=new GetOwnerPetsResponse.Pet();
            DatatypeFactory datatypeFactory=new DatatypeFactoryImpl();
            pet.setPetId(p.getId());
            pet.setBirthDate(datatypeFactory.newXMLGregorianCalendar(p.getBirthDate().toString()));
            pet.setPetType(p.getType().toString());
            return pet;
        }).collect(Collectors.toList());
        getOwnerPetsResponse.setPet(pets1);
        return getOwnerPetsResponse;
    }

}
