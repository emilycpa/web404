package com.database.po;

public class Product {
	private int id;
	private String name;
	private String code;
	private String bssCode;
	private String ecsCode;
	private String url;
	private String type;
	private String description;
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBssCode() {
		return bssCode;
	}

	public void setBssCode(String bssCode) {
		this.bssCode = bssCode;
	}

	public String getEcsCode() {
		return ecsCode;
	}

	public void setEcsCode(String ecsCode) {
		this.ecsCode = ecsCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
