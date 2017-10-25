package com.heyrul.springwebmvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Karyawan")
public class Karyawan {
	
	@Id
	@Column(name="nip", unique=true, nullable=false)
	private String nip;
	
	@Column(name="nama", nullable=false)
	private String nama;
	
	@Column(name="jabatan", nullable=false)
	private String jabatan;
	
	@Column(name="gaji")
	private int gaji;
	
	@Column(name="alamat")
	private String alamat;

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public int getGaji() {
		return gaji;
	}

	public void setGaji(int gaji) {
		this.gaji = gaji;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	

}
