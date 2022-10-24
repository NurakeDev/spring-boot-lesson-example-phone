package nurakedevgroup.com.springbootlessonexamplephone.service.Impl;

import nurakedevgroup.com.springbootlessonexamplephone.entity.Phone;
import nurakedevgroup.com.springbootlessonexamplephone.repository.PhoneRepository;
import nurakedevgroup.com.springbootlessonexamplephone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {


    @Autowired
    private PhoneRepository repository;

    @Override
    public List<Phone> findAll() {
        return repository.findAll();
    }

    @Override
    public Phone getById(Long id) {
        Optional<Phone> optionalPhone = repository.findById(id);
        if (optionalPhone.isPresent()) {
            return optionalPhone.get();
        }
        return new Phone();
    }

    @Override
    public Phone save(Phone phone) {
        if (phone.getName() != null && phone.getModel() != null && phone.getInfo() != null && phone.getMacAddress() != null)
            return repository.save(phone);
        return new Phone();
    }

    @Override
    public Phone update(Long id, Phone phone) {

        Phone oldPhone = getById(id);

        if (id != null && oldPhone.getId().equals(id)) {
            if (phone.getModel() != null && !oldPhone.getModel().equals(phone.getModel()))
                oldPhone.setModel(phone.getModel());
            if (phone.getMacAddress() != null && !oldPhone.getMacAddress().equals(phone.getMacAddress()))
                oldPhone.setMacAddress(phone.getMacAddress());
            if (phone.getInfo() != null && !oldPhone.getInfo().equals(phone.getInfo()))
                oldPhone.setInfo(phone.getInfo());
            if (phone.getName() != null && !oldPhone.getName().equals(phone.getName()))
                oldPhone.setName(phone.getName());
            return repository.save(oldPhone);
        }
        return new Phone();
    }

    @Override
    public String delete(Long id) {

        Phone phone = getById(id);

        repository.delete(phone);

        return (phone != null)?"Ma`lumot o`chirildi":"Bunday Phone mavjud emas.";

    }


}
