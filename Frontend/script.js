let randomNumber;
let attemptsLeft;
let playerName = '';

function startGame() {
  const nameInput = document.getElementById("playerNameInput").value.trim();
  if (!nameInput) {
    alert("Please enter your name!");
    return;
  }

  playerName = nameInput;
  document.getElementById("welcomeText").textContent = `Good luck, ${playerName}! 🎉`;
  document.getElementById("nameModal").style.display = "none";
  document.getElementById("gameBox").style.display = "block";
  restartGame();
}

function restartGame() {
  randomNumber = Math.floor(Math.random() * 100) + 1;
  attemptsLeft = 5;
  document.getElementById("guessInput").value = "";
  document.getElementById("feedback").textContent = "Game restarted.";
  document.getElementById("feedback").className = "feedback success";
  document.getElementById("attemptsLeft").textContent = attemptsLeft;
}

function makeGuess() {
  const guess = parseInt(document.getElementById("guessInput").value);

  if (isNaN(guess) || guess < 1 || guess > 100) {
    showFeedback("Please enter a valid number between 1 and 100.", "error");
    return;
  }

  attemptsLeft--;
  document.getElementById("attemptsLeft").textContent = attemptsLeft;

  if (guess === randomNumber) {
    showFeedback(`🎉 Well done, ${playerName}! You guessed it right!`, "success");
  } else if (attemptsLeft === 0) {
    showFeedback(`❌ Sorry ${playerName}, you're out of attempts! The number was ${randomNumber}.`, "error");
  } else {
    const hint = guess < randomNumber ? "higher" : "lower";
    showFeedback(`❗ Nope! Try a ${hint} number.`, "warning");
  }
}

function showFeedback(message, type) {
  const feedback = document.getElementById("feedback");
  feedback.textContent = message;
  feedback.className = `feedback ${type}`;
}
//final