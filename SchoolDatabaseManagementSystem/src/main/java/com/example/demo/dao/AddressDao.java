package com.example.demo.dao;

import com.example.demo.entity.Address;
import com.example.demo.utility.ResponseStructure;

public interface AddressDao {

	Address saveAddress(Address a);

	Address updateAddress(Address a, int id);

	boolean deleteAdress(int id);

	Address fetchAddress(int id);
}
