/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.daos;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.heyrul.springwebmvc.models.Karyawan;

@Repository
@Transactional(readOnly=false)
public class KaryawanDaoImpl implements KaryawanDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void insert(Karyawan karyawan) {
		sessionFactory.getCurrentSession().save(karyawan);
	}

	public void update(Karyawan karyawan) {
		sessionFactory.getCurrentSession().update(karyawan);
	}

	public void delete(String nip) {
		TypedQuery query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Karyawan WHERE nip = :nip");
		query.setParameter("nip", nip);
		query.executeUpdate();
	}

	public List<Karyawan> getAllData() {
		TypedQuery<Karyawan> query = sessionFactory.getCurrentSession().createQuery("FROM Karyawan");
		return query.getResultList();
	}

}
