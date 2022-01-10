package com.example.petproject.DAO;

import com.example.petproject.entity.Apartment;

import java.util.List;

public interface DAO<T> {

	void add(T t);

	boolean update(Apartment apartment);

	boolean delete(int id);

	T getByID(int id);

	List<T> getAllApartment();
}
