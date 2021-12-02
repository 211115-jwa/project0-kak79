package com.revature.models;

import java.util.Objects;

public class Bike {
	private int id;
	private String type;
	private String color;
	private String m_f_config;
	private int speeds;
	
	public Bike(int id, String type, String color, String m_f_config, int speeds) {
		super();
		this.id = id;
		this.type = type;
		this.color = color;
		this.m_f_config = m_f_config;
		this.speeds = speeds;
	}

	public Bike(String type, String color, String m_f_config, int speeds) {
		super();
		this.type = type;
		this.color = color;
		this.m_f_config = m_f_config;
		this.speeds = speeds;
	}

	public Bike(int id) {
		super();
		this.id = id;
	}

	public Bike() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getM_f_config() {
		return m_f_config;
	}

	public void setM_f_config(String m_f_config) {
		this.m_f_config = m_f_config;
	}

	public int getSpeeds() {
		return speeds;
	}

	public void setSpeeds(int speeds) {
		this.speeds = speeds;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", type=" + type + ", color=" + color + ", m_f_config=" + m_f_config
				+ ", speeds=" + speeds + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, id, m_f_config, speeds, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		return Objects.equals(color, other.color) && id == other.id && Objects.equals(m_f_config, other.m_f_config)
				&& speeds == other.speeds && Objects.equals(type, other.type);
	}

	
}
