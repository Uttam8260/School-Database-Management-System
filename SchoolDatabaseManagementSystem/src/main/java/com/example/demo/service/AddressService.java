package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.utility.ResponseStructure;

public interface AddressService {

	ResponseStructure<Address> saveAddress(Address a);

	ResponseStructure<Address> updateAddress(Address a, int id);

	ResponseStructure<Address> deleteAdress(int id);

	ResponseStructure<Address> fetchAddress(int id);
}
