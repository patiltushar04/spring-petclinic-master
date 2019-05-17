package org.springframework.samples.petclinic.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.ValidationUtils;

import java.time.LocalDate;

@Service
public class OwnerBO {

    @Autowired
    private OwnerRepository owners;

    @Autowired
    private PetRepository pets;

    public final String restrictedName="dan";
    public final String defaultPetName="Bambi";

    @Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public Owner validateAndStore(Owner owner){
        if(owner.getLastName().contains(restrictedName))
            throw new IllegalArgumentException("The supplied Last must not have."+restrictedName);

        this.owners.save(owner);
        Pet pet=new Pet();
        pet.setName("Bambi");
        pet.setBirthDate(LocalDate.of(2017, 01, 01));
        PetType petType = new PetType();
        petType.setId(3);
        petType.setName("hamster");
        pet.setType(petType);
        owner.addPet(pet);
        this.pets.save(pet);
        return owner;
    }

}
