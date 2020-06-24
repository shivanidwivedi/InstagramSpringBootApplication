// Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyCicMkIn9C3p60Ey1A6LNxtPi7q_plGti8",
    authDomain: "chat-app-2d4fd.firebaseapp.com",
    databaseURL: "https://chat-app-2d4fd.firebaseio.com",
    projectId: "chat-app-2d4fd",
    storageBucket: "chat-app-2d4fd.appspot.com",
    messagingSenderId: "55777860677",
    appId: "1:55777860677:web:33fc2e039b74c58c9ad72c"
  };

// Initialize Firebase
firebase.initializeApp(firebaseConfig);

// Reference Cloud Firestores method in Firebase
var db = firebase.firestore();

// Get the name for the user
if (!localStorage.getItem('name')) {
	name = prompt('What is your name?')
	localStorage.setItem('name', name)
} else {
	name = localStorage.getItem('name')
}
document.querySelector('#name').innerText = name

// Change name
document.querySelector('#change-name').addEventListener('click', () => {
	name = prompt('What is your name?')
	document.querySelector('#name').innerText = name
})

document.querySelector('#message-form').addEventListener('submit', e => {
	e.preventDefault();
	db.collection("messages")
	.add({
		name: name,
		message: document.querySelector('#message-input').value
	})
	.then(function (docRef) {
		console.log("Document written with ID: ", docRef.id);
		document.querySelector('#message-form').reset()
	})
	.catch(function (error) {
		console.error("Error adding document: ", error);
	});
})
//Real time listener
db.collection("messages")
.onSnapshot(function(snapshot) {
	document.querySelector('#messages').innerHTML = ""
	snapshot.forEach(function(doc) {
		var message = document.createElement('div')
		message.innerHTML = `
		<p class="name">${doc.data().name}</p>
		<p>${doc.data().message}</p>
		`
		document.querySelector('#messages').prepend(message)
	});
});

//Delete the messages collection from the database
document.querySelector('#clear').addEventListener('click', () => {
	// Step 1
    db.collection("messages")
    .get()
    // Step 2 (if success)
    .then(function(snapshot) {
        snapshot.forEach(function(doc) {
            // Step 3
			db.collection("messages").doc(doc.id).delete()
            // Step 4 (if success)
            .then(function() {
				console.log("Document successfully deleted!");
			})
            // Step 4 (if error)
            .catch(function(error) {
				console.error("Error removing document: ", error);
			});
        });
    })
    // Step 2 (if error)
    .catch(function(error) {
        console.log("Error getting documents: ", error);
    });
})