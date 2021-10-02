# Firebase Connect Issue

ISSUE:
Firebase firestore is taking huge reconnecting time, when the app is moved to background and bought again to the foreground.

HOW TO REPRODUCE:
1. Install the app.
2. Launch the app and data will be received.
3. Press on recent apps icon in your android phone, or move to some other app like youtube or any messaging app.
4. Come back to this app after a minute or more
5. Firebase firestore data wont be received.

For better reproducing the issue
- Keep phone in battery saving mode
- Use phone with RAM 6gb or less
- Do not plug in the phone to computer
- Do not charge the phone while reproducing
- Lock the phone for a while

PHONE USED WHILE RECREATING THE ISSUE:
Samsung Galaxy s9 plus
Android version 10
RAM 6gb
 
