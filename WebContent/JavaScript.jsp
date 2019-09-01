<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script>
	var name1 = "Hi";

	var f = function greetMe1() {
		console.log("Hello " + name1);
	}

	function greetMe() {
		var name = "Himanshu";

		var input = "Hi";

		if (input === undefined) {
			console.log("Input is Undefined");
		} else {
			console.log(name);
			name1 = "Tomar";
		}

		console.log("Hello " + name1);

		console.log("The value name1 is " + name1);
		//console.log("The value of b is " + b);

		var myArray = [];
		if (!myArray[0]) {
			console.log("Value is null ");
		}

		var a;
		console.log(a + 2);

		var b = null;
		console.log(b * 32);

		console.log("37" - 7);

		f();

		console.log("Hoisted Variable value " + hoisted);
		var hoisted = "Hoisted";
		console.log("Hoisted Variable value " + hoisted);
		var name1;
		console.log("Global Variable value " + name1);
		console.log("Unary Plus " + ((+"1.1") + (+"1.1")));
		console.log("Parse Float " + (parseFloat("1.1") + parseFloat("1.1")));

		var arrayLiteral = [ "Java", "Spring", "Hibernat", "Struts",
				"JavaScript", ];

		console.log("Array Value " + arrayLiteral.length);

		var booleanVar = true;

		var octal = 057;

		var fraction = 10 / 3;

		console.log("Boolean value " + booleanVar);
		console.log("Binary Value " + octal);
		console.log("Binary Value " + fraction);

		var sales = "Toyota";

		function carTypes(name) {
			if (name == "Range Rover") {
				return name;
			} else {
				return "Sorry, we don't sell " + name + ".";
			}
		}

		var car = {
			myCar : "Saturn",
			getCar : carTypes("Range Rover"),
			special : sales
		};

		console.log(car.myCar);
		console.log(car.getCar);
		console.log(car.special);

		var car = {
			manyCars : {
				a : "Saab",
				"b" : "SUV"
			},
			7 : "Mazda"
		};
		
		var ferrari1 = Object.create(car);
		ferrari1.color = "red"; 
		
		console.log(Object.getPrototypeOf(ferrari1));
		console.log(ferrari1);

		console.log(car);
		console.log(car[7]);

		var unusualPropertyNames = {
			"" : "An empty string",
			"!" : "Bang!"
		}
		// console.log(unusualPropertyNames."");   // SyntaxError: Unexpected string
		console.log(unusualPropertyNames[""]); // An empty string
		// console.log(unusualPropertyNames.!);    // SyntaxError: Unexpected token !
		console.log(unusualPropertyNames["!"]); // Bang!

		var foo = {
			a : "alpha",
			2 : "two"
		};
		console.log(foo.a); // alpha
		console.log(foo[2]); // two
		//console.log(foo.2);  // Error: missing ) after argument list
		//console.log(foo[a]); // Error: a is not defined
		console.log(foo["a"]); // alpha
		console.log(foo["2"]); // two

		console.log(" one line \n another line");

		console.log(" one line c:\\\\temp another line");

		if ((name1 = name)) {
			console.log("name = name1");
		}

		var floatVar = new Object(1.21);
		console.log("Himanshu "+floatVar.constructor.toString());
		var booleanVar = new Object(true);
		var booleanObject = new Boolean(true);
		var intVar = new Object(12);
		var stringVar = new Object("Hello");

		console.log(floatVar);
		console.log(booleanVar);
		console.log(booleanObject);
		console.log(intVar);
		console.log(stringVar);
		console.log(stringVar.length);

		//console.log(floatVar);

		var fruittype = "Oranges";

		switch (fruittype) {
		case "Oranges":
			console.log("Oranges are $0.59 a pound.");
			break;
		case "Apples":
			console.log("Apples are $0.32 a pound.");
			break;
		case "Bananas":
			console.log("Bananas are $0.48 a pound.");
			break;
		case "Cherries":
			console.log("Cherries are $3.00 a pound.");
			break;
		case "Mangoes":
			console.log("Mangoes are $0.56 a pound.");
			break;
		case "Papayas":
			console.log("Mangoes and papayas are $2.79 a pound.");
			break;
		default:
			console.log("Sorry, we are out of " + fruittype + ".");
		}
		console.log("Is there anything else you'd like?");

		/* -------------------------------------------------- */

		function UserException(message) {
			this.message = message;
			this.himanshu = message;
			this.name = "UserException";
		}
		//console.log(execptionObj);

		UserException.prototype.toString = function() {
			return this.name + ': "' + this.message + '"';
		}

		//throw new UserException("Value too high");

		function CustomFunction(message) {
			this.name = "UserException";
			this.himanshu = message;
		}

		var a = new CustomFunction('CustomMessage');
		console.log(a.himanshu);

	}
	
	function Test(nm)
	{
		this.name = nm;
	}
	Test.prototype.getName = function(){
		console.log(this.name);
	}

	function Vehicle(nm) {
		Test.call(this, nm);
	}

	Vehicle.prototype = new Test();

	var veh = new Vehicle('ferrari');
	veh.getName();

	var veh2 = new Vehicle('audi');
	veh2.getName();
	
	function Car(nm)
	{
		Vehicle.call(this, nm);
	}
	Car.prototype = new Vehicle();
	
	var cr = new Car('audi a8');	
	cr.getName();
	
</script>
</head>

<body>

	<h1>My First JavaScript</h1>

	<button type="button" onclick="greetMe()">Click me to display
		Date and Time.</button>

	<p id="demo"></p>

</body>
</html>
