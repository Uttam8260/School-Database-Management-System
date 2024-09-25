package com.example.demo.serviceImplementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.service.AddressService;
import com.example.demo.utility.ResponseStructure;


@Service
public class AddressServiceImplementation implements AddressService {

	@Autowired
	private AddressDao dao;

	@Override
	public ResponseStructure<Address> saveAddress(Address a) {
		Address address = dao.saveAddress(a);
		return new ResponseStructure<Address>(201, "Adress is saved inside DB succesfully", address, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> updateAddress(Address a, int id) {
		Address address = dao.updateAddress(a, id);
		return new ResponseStructure<Address>(200, "Adress is updated inside DB succesfully", address, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> deleteAdress(int id) {
		dao.deleteAdress(id);
		return new ResponseStructure<Address>(200, "Adress is deleted inside DB succesfully", null, LocalDateTime.now());
	}

	@Override
	public ResponseStructure<Address> fetchAddress(int id) {
		Address address = dao.fetchAddress(id);
		return new ResponseStructure<Address>(201, "Adress is fetched from DB succesfully", address, LocalDateTime.now());
	}
}
