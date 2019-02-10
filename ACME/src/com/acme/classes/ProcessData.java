package com.acme.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ProcessData {

	public void calculateSalary(String[] data) {
		String schedule;
		String[] schedule2;
		double hourValue;
		double totalSalary;

		final String scheduleFormat = "(?i)(MO|TU|WE|TH|FR|SA|SU)\\d{1,2}:\\d{1,2}-\\d{1,2}:\\d{1,2}";

		for (int i = 0; i < data.length; i++) {
			String stringData = "";

			stringData = data[i];
			totalSalary = 0.0;

			String[] data2 = stringData.split("=", 2);

			if (data2.length >= 2) {

				schedule = data2[1];
				schedule2 = schedule.split(",", schedule.length());
				String employeeName = data2[0];
				String[] arraySchedule = schedule2;
				String stringSchedule = "";
				
				System.out.println("Case "+(i+1)+": \n");
				System.out.println("INPUT\n");
				
				System.out.println(data[i]+"\n");

				for (int j = 0; j < arraySchedule.length; j++) {

					stringSchedule = arraySchedule[j];

					if (Pattern.matches(scheduleFormat, stringSchedule)) {

						String day = stringSchedule.substring(0, 2);
						String daySchedule = stringSchedule.substring(2,
								stringSchedule.length());

						String dayScheduleArray[] = daySchedule.split("-",
								daySchedule.length());

						int hour = Integer.parseInt(daySchedule.substring(0,
								daySchedule.indexOf(":")));

						String time1 = dayScheduleArray[0];
						String time2 = dayScheduleArray[1];

						double hours = getNumberHours(time1, time2);

						if (hours > 0) {

							int hour1 = Integer.parseInt(dayScheduleArray[1]
									.substring(0,
											dayScheduleArray[1].indexOf(":")));

							switch (day) {

							case "MO":
							case "TU":
							case "WE":
							case "TH":
							case "FR":

								if (hour1 <= 24) {
									if (hour >= 0 && hour < 9) {
										hourValue = 25.0 * hours;
										totalSalary += hourValue;

									} else if (hour >= 9 && hour < 18) {
										hourValue = 15.0 * hours;
										totalSalary += hourValue;

									} else if (hour >= 18 && hour < 23) {
										hourValue = 20.0 * hours;
										totalSalary += hourValue;

									}
								} else {
									System.out
											.println("A data has the wrong hour");
								}
								break;
							case "SA":
							case "SU":
								if (hour1 <= 24) {

									if ((hour >= 0 && hour < 9)) {
										hourValue = 30.0 * hours;
										totalSalary += hourValue;

									} else if ((hour >= 9 && hour < 18)) {
										hourValue = 20.0 * hours;
										totalSalary += hourValue;

									} else if ((hour >= 18 && hour < 24)) {
										hourValue = 25.0 * hours;
										totalSalary += hourValue;

									}

								} else {
									System.out
											.println("A data has the wrong hour");
								}

								break;
							default:
								System.out.println("The day is misspelled");
							}

						} else {
							System.out.println("Total hours is negative");
						}

					}else{
						System.out.println(employeeName+"'s schedule "+ "does not comply with the format: "+stringSchedule);
					}

				}
				System.out.println("OUTPUT \n");
				System.out.println("The amount to pay " + employeeName
						+ " is: " + totalSalary + " USD"+" \n");
			} else {
				System.out.println("Does not comply with the format");
			}

		}

	}

	private double getNumberHours(String time1, String time2) {
		if (time2.equals("00:00")) {
			time2 = "24:00";
		}

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1 = null;
		Date date2 = null;

		try {
			date1 = format.parse(time1);
			date2 = format.parse(time2);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		double difference = date2.getTime() - date1.getTime();
		return (((difference / 1000) / 60) / 60);
	}

}
