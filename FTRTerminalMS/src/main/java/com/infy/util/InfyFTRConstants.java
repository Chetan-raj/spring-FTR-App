package com.infy.util;

public enum InfyFTRConstants {
	
	
	

	
	
	//Exception message constants
		TERMINAL_NOT_FOUND("terminal.empty"),
		TERMINAL_CAPACITY_FAILED("terminal.capacity.failed"),
		GENERAL_EXCEPTION("general.exception"),
		TERMINAL_NOT_FOUND_FOR_ID("terminal.notFound"),
		TERMINAL_ITEM_NOTFOUND("terminal.itemtype.notFound"),
		
		
	//Response messages constants
		TERMINAL_UPDATE_SUCCESS("terminal.update.success"),
		TERMINAL_DELETE_SUCCESS("terminal.delete.success");
	
		
		private final String type;

		private InfyFTRConstants(String type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return this.type;
		}

}
