package net.yourhome.common.net.model;
public class Device {

		private String registrationId;
		private String name;
		private int width;
		private int height;

		public Device(String registrationId, String name, int width, int height) {
			this.registrationId = registrationId;
			this.name = name;
			this.width = width;
			this.height = height;
		}

		public String toString() {
			return name+", "+width+"*"+height;
		}
		
		
		/**
		 * @return the width
		 */
		public int getWidth() {
			return width;
		}

		/**
		 * @param width the width to set
		 */
		public void setWidth(int width) {
			this.width = width;
		}

		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}

		/**
		 * @param height the height to set
		 */
		public void setHeight(int height) {
			this.height = height;
		}

		/**
		 * @return the registrationId
		 */
		public String getRegistrationId() {
			return registrationId;
		}

		/**
		 * @param registrationId
		 *            the registrationId to set
		 */
		public void setRegistrationId(String registrationId) {
			this.registrationId = registrationId;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

	}