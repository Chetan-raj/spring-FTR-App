package com.infy.FTR.Util;

public enum InfyFTRConstants {

		//Exception message constants
		USER_NOT_FOUND("user.notFound"),
		USER_ALREADY_EXISTS("user.alreadyexists"),
		USER_UPDATE_FAILURE("user.update.fail"),
		INPUT_PARAMETER_MISSING("input.parameter.missing"),
		USER_LOGIN_FAILURE("user.login.failure"),
		GENERAL_EXCEPTION_MESSAGE("genereal.exception"),
		//Success message constants
		USER_CREATE_SUCCESS("user.create.success"),
		USER_UPDATE_SUCCESS("user.update.success"),
		USER_DELETE_SUCCESS("user.delete.success"),
		USER_FOUND("user.found"),
		USER_LOGIN_SUCCESS("user.login.success");
	private final String type;

		private InfyFTRConstants(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type;
		}
	}

