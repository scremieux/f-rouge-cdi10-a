var loginVerif = (function(utilConn) {
	'use strict';
	console.log("module ok");
	if (utilConn ===undefined) {
		console.log("pas connecté");
		window.location.assign('/MDE_GUI_POC/login');
	} else {
		console.log("connecté");
	}

});
//.call(this);