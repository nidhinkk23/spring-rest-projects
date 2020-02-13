package com.tyss.springmappingrest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.springmappingrest.dto.EmployeeAddressInfo;
import com.tyss.springmappingrest.dto.EmployeePrimaryInfo;
import com.tyss.springmappingrest.dto.EmployeeSecondaryInfo;

import lombok.extern.java.Log;


@Log
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	@Override
	public boolean addEmployee(EmployeeSecondaryInfo employeeSecondaryInfo) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(employeeSecondaryInfo);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {
				log.info(e.toString());
			}
			
			return false;

		}
		
		
		
		
	}


	@Override
	public boolean addEmployeP(EmployeePrimaryInfo employeePrimaryInfo) {
		
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(employeePrimaryInfo);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {
				log.info(e.toString());
			}
			
			return false;

		}
	}


	@Override
	public boolean addEmployeeDetailsOneToMany(EmployeeAddressInfo addressInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(addressInfo);
			transaction.commit();
			return true;
			
		} catch (Exception e) {
			log.info(e.getMessage());

			for (StackTraceElement element : e.getStackTrace()) {
				log.info(e.toString());
			}
			
			return false;

		}
	}

}
