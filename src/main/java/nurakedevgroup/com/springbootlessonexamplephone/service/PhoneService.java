package nurakedevgroup.com.springbootlessonexamplephone.service;


import nurakedevgroup.com.springbootlessonexamplephone.entity.Phone;

import java.util.List;

public interface PhoneService {

    List<Phone> findAll();

    Phone getById(Long id);

    Phone save(Phone phone);

    String update(Long id, Phone phone);

    String delete(Long id);

}
