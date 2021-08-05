package com.vti.railway12.entity;

import java.util.stream.Stream;

public enum TypeQuestion {

	Essay(1), Multiple_choice(2);
	
	private int typeID;
	private TypeQuestion(int typeID) {
		this.typeID = typeID;
	}

    public int getTypeId() {
        return typeID;
    }
    
    public static TypeQuestion of(int typeID) {
        return Stream.of(TypeQuestion.values())
          .filter(p -> p.getTypeId() == typeID)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
    
}
