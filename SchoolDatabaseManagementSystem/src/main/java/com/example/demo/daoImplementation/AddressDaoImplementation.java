package com.example.demo.daoImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.AddressDao;
import com.example.demo.entity.Address;
import com.example.demo.exceptionalHandling.EntityNotPresentException;
import com.example.demo.repositries.AddressRepositry;

@Repository
public class AddressDaoImplementation implements AddressDao {

	@Autowired
	private AddressRepositry repository;

	@Override
	public Address saveAddress(Address a) {
		return repository.save(a);
	}

	@Override
	public Address updateAddress(Address a, int id) {
		if (!repository.existsById(id)) {
			throw new EntityNotPresentException("Adress with id " + id + " is not present");
		}
		a.setId(id);
		return repository.save(a);
	}

	@Override
	public boolean deleteAdress(int id) {
		Address address = fetchAddress(id);
		repository.delete(address);
		return true;
	}

	@Override
	public Address fetchAddress(int id) {
		Optional<Address> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityNotPresentException("Adress with id " + id + " is not present"));
	}
}
