window.addEventListener("DOMContentLoaded", (domEvent) => {
	init();
});

// Function that works if the page is initialized
const init = () => {
	// Get courses and retrieve the data to a function that fills the combobox
	getCourses().then(data => {
		fillCoursesCombobox(data);
	});

	// Replace the history of the navigator
	if (window.history.replaceState) {
		window.history.replaceState(null, null, window.location.href);
	}
}

// Get a promise of the request containing the courses
const getCourses = async () => {
	const response = await fetch(`${window.location.origin}/course`);

	return response.json();
}

// Fill the combobox of courses
const fillCoursesCombobox = (dataArray) => {
	const selectCourse = document.getElementById("course");
	
	if (selectCourse) {
		dataArray.forEach(data => {
			const option = document.createElement("option");
			option.value = data.id;
			option.textContent = data.name
			selectCourse.appendChild(option);
		})		
	}
}