package nurakedevgroup.com.springbootlessonexamplephone.service.Impl;

import nurakedevgroup.com.springbootlessonexamplephone.entity.Phone;
import nurakedevgroup.com.springbootlessonexamplephone.service.PhoneService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private List<Phone> phoneList = new ArrayList<>(Arrays.asList(
       new Phone(1L, "Samsung Galaxy S51", "fc:64:1a:s5:8d:6s", 971234567),
       new Phone(2L, "iPhone 6", "34:gd:5F:4K:jf:7u", 887562457)
    ));


    @Override
    public List<Phone> findAll() {
        return phoneList;

    }

    @Override
    public Phone getById(Long id) {
        for (Phone phone : phoneList) {
            if(id != null && phone.getId().equals(id)){
                return phone;
            }
        }
        return null;
    }

    @Override
    public Phone save(Phone phone) {
        phone.setId((long)phoneList.size() + 1);
        phoneList.add(phone);
        return phone;
    }

    @Override
    public String update(Long id, Phone phone) {

        for (Phone item : phoneList) {
            if (id != null && item.getId().equals(id)){
                if (phone.getModel() != null && !item.getModel().equals(phone.getModel()))
                    item.setModel(phone.getModel());
                if (phone.getMacAddress() != null && !item.getMacAddress().equals(phone.getMacAddress()))
                    item.setMacAddress(phone.getMacAddress());
                if (phone.getPhoneNumber() != null && !item.getPhoneNumber().equals(phone.getPhoneNumber()))
                    item.setPhoneNumber(phone.getPhoneNumber());
                return "O`zgartirildi.";
            }
        }
        return "Bunday Telefon topilmadi.";
    }

    @Override
    public String delete(Long id) {
        return phoneList.removeIf(phone -> (id != null && phone.getId().equals(id)))?
                "O`chrildi":"Bunday telefon topilmadi.";
    }


}
