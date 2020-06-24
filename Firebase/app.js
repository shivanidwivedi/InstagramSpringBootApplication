var db = firebase.firestore();

<script src="https://www.gstatic.com/firebasejs/7.15.4/firebase-app.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/7.15.4/firebase-analytics.js"></script>

<script>
  // Your web app's Firebase configuration
  var firebaseConfig = {
    apiKey: "AIzaSyCicMkIn9C3p60Ey1A6LNxtPi7q_plGti8",
    authDomain: "chat-app-2d4fd.firebaseapp.com",
    databaseURL: "https://chat-app-2d4fd.firebaseio.com",
    projectId: "chat-app-2d4fd",
    storageBucket: "chat-app-2d4fd.appspot.com",
    messagingSenderId: "55777860677",
    appId: "1:55777860677:web:33fc2e039b74c58c9ad72c",
    measurementId: "G-092CH5HQ1S"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  firebase.analytics();
</script>

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
	localStorage.setItem('name', name)
	document.querySelector('#name').innerText = name
})