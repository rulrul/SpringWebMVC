/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.daos;

import java.util.List;

import com.heyrul.springwebmvc.models.Karyawan;

public interface KaryawanDao {
	
	public void insert(Karyawan karyawan);
	
	public void update(Karyawan karyawan);
	
	public void delete(String nip);
	
	public List<Karyawan> getAllData();

}
