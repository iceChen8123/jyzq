package com.ice.server;

public enum ChoiseType {

	Cloth("cloth", "衣"), Food("food", "食");

	private String choiceCode;
	private String choiceName;

	private ChoiseType(String choiceCode, String choiceName) {
		this.choiceCode = choiceCode;
		this.choiceName = choiceName;
	}

	public String getChoiceCode() {
		return choiceCode;
	}

	public void setChoiceCode(String choiceCode) {
		this.choiceCode = choiceCode;
	}

	public String getChoiceName() {
		return choiceName;
	}

	public void setChoiceName(String choiceName) {
		this.choiceName = choiceName;
	}

}
