module Game {

	requires com.jfoenix;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	
	opens application;
	opens controller;
	opens css;
	opens data;
	opens img.asset;
	opens img.asset.cars;
	opens img.asset.chars;
	opens img.map;
	opens music;
	opens value;
	opens view;
}