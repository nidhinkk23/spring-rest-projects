package com.tyss.springmappingrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

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
		System.out.println("employeeSecondaryInfo:-"+employeeSecondaryInfo);
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


	@Override
	public List<EmployeePrimaryInfo> searchEmployee(int empid) {
		String jpql = "select p from EmployeePrimaryInfo p where p.empid=:empid";
		
		EntityManager manager = factory.createEntityManager();
		TypedQuery<EmployeePrimaryInfo> query = 
				manager.createQuery(jpql,EmployeePrimaryInfo.class);


		query.setParameter("empid", empid);

		return query.getResultList();
	}


	@Override
	public boolean editDetails(EmployeePrimaryInfo employeePrimaryInfo) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeePrimaryInfo infoBean = manager.find(EmployeePrimaryInfo.class, employeePrimaryInfo.getEmpid());


		infoBean.setName(employeePrimaryInfo.getName());
		infoBean.setAddressInfos(employeePrimaryInfo.getAddressInfos());
		infoBean.setSecondary(employeePrimaryInfo.getSecondary());
		infoBean.setExperiance(employeePrimaryInfo.getExperiance());
		infoBean.setSalary(employeePrimaryInfo.getSalary());
		
		manager.persist(infoBean);
		transaction.commit();

		return true;
	}

}
