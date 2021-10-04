# Hacktoberfest 2021 ✨
Welcome everyone!:raised_hands: This repository is made for everyone who wanted to learn about open-source and paricipate in Hacktoberfest 2021.

[![forthebadge](https://forthebadge.com/images/badges/built-by-developers.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/for-you.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/powered-by-coffee.svg)](https://forthebadge.com)

![](https://img.shields.io/maintenance/yes/2021)
![](https://img.shields.io/github/issues/ShivamYadav-Coding/hacktoberfest-2021?color=%23F74700)
![](https://img.shields.io/github/stars/ShivamYadav-Coding/hacktoberfest-2021)
![](https://img.shields.io/github/contributors/ShivamYadav-Coding/hacktoberfest-2021)
![](https://img.shields.io/github/issues-pr/ShivamYadav-Coding/hacktoberfest-2021)
![](https://img.shields.io/github/last-commit/ShivamYadav-Coding/hacktoberfest-2021)

![](https://img.shields.io/badge/Python-green)
![](https://img.shields.io/badge/Kotline-cyan)
![](https://img.shields.io/badge/Java-blue)
![](https://img.shields.io/badge/C-yellowgreen)
![](https://img.shields.io/badge/C++-blueviolet)
![](https://img.shields.io/badge/Csharp-red)
![](https://img.shields.io/badge/Js-yellow)

Hey there!👋 

## What can you do here?🧐
* You can solve questions put up by contributors (tag moderators in comment to assign an issue to you and mention the language you will be using).
* You can put up a problem yourself.
* You can even contribute a project made by you!
* Please read this issue [click here](https://github.com/ShivamYadav-Coding/hacktoberfest-2021/issues/7) for more information.

## New to github? No problem :) Refer to these resources 🆕
* In Hindi Language -> Learn complete Git and Github in 1 video by Anuj Bhaiya: [Youtube](https://www.youtube.com/watch?v=uaeKhfhYE0U&ab_channel=AnujBhaiya)
* In English Language -> Complete Git and GitHub Tutorial: [Youtube](https://www.youtube.com/watch?v=apGV9Kg7ics&ab_channel=KunalKushwaha)
* Git and github articles on atlassian.com: [Website](https://www.atlassian.com/git/tutorials)

## Steps to put up an issue:📑

First let's see when should you create an issue?
* If you want to contribute a question or project.
* If you have a better solution to an existing solved issue.

### To create an issue:

Click on the [Issue button](https://github.com/ShivamYadav-Coding/hacktoberfest-2021/issues) at top of the page:<br>
![pic1](https://user-images.githubusercontent.com/69135897/135752015-4a227b0f-0681-4f8a-bde6-9d6a3c3723d5.png)

Click new issue and fill up the details!<br>
![pic2](https://user-images.githubusercontent.com/69135897/135752032-9d34c5b4-5539-4ea2-8ee0-bf0eb331831d.png)

__Note: Issues must clearly mention what they are addressing, if a problem is being put up then explain it using an example.__

## Get contributing🤩

__Note: One must read [CODE_OF_CONDUCT](https://github.com/ShivamYadav-Coding/hacktoberfest-2021/blob/main/CODE_OF_CONDUCT.md) before starting work on any issue__

First things first, In order to contribute you have to create a Pull Request from your forked repo which is a remote clone of this upstream repository.<br>
<img width="520" alt="pic3" src="https://user-images.githubusercontent.com/69135897/135800140-b70ee453-9b53-48e9-bac2-62258678cf80.png">

1. Click this button at the top of screen to fork this repo, don't forget to star the repository!:<br>
![pic4](https://user-images.githubusercontent.com/69135897/135800163-8e87a0f3-1643-4b54-aac5-2cbd81edfffa.jpg)

2. Now head over to the forked repository and copy the clone HTTPS URL:<br>
![pic5](https://user-images.githubusercontent.com/69135897/135800183-b3102af5-8ed6-4e81-8711-9fb13309e87e.png)

3. Next up clone the forked repo on to the local machine using:<br>

    ``git clone <copied-fork-link>``

4. Run these command to add remote origin
   ```
   git remote add origin <The url of forked github repository>
   ```
   If this command give message like git remote already exist then run this command
   ```
   git remote set-url origin <The url of forked github repository>
   ```
   
5. It is critical to keep your [forked repository in sync the upstream](https://www.freecodecamp.org/news/how-to-sync-your-fork-with-the-original-git-repository/) repository so merge conflicts can be avoided:
    ```
    git remote add upstream https://github.com/ShivamYadav-Coding/hacktoberfest-2021.git
    git fetch upstream
    git pull upstream main
    ```
    
6. Create a seperate branch to work on:<br>

    The branch name must be selected according to the issue<br>

    ``git checkout -b <branch-name>``

7. Contributors must follow the directory structure guidelines:
    * All files must be kept in a directory.
    * Directory name must resemble the issue assigned.
    * Based on the language used, create a directory inside the language directory.
    * Example: If I am writing in `Python` I will create a directory inside `Python` directory.
    * In case a project is being contributed make sure to add the files inside a directory(name according to project) which in turn must be placed inside the `Projects` directory.
    * Changes done by you will not affect existing structure of the project.
    * Add a README.md with your name and link to github profile using \[your-name](link-to-profile)

8. After the contribution work is ready go ahead and add it to staging area:<br>

    ``git add -A``

9. Now it is time to commit your changes and sync these changes to forked repo:<br>

    ``git commit -m <your_message>``

    ``git push origin <branch-name>`` 


10. Issue a [pull request](https://www.atlassian.com/git/tutorials/making-a-pull-request) from forked repo to this repo:<br>
    * Head over to `Pull Request` tab in the forked repo and click on `New Pull Request`
       ![pic6](https://user-images.githubusercontent.com/69135897/135800300-c2a07e53-3679-467a-a260-9237befc4ef7.png)

    * Verify base and head repository name and branch names.
        ![pic7](https://user-images.githubusercontent.com/69135897/135800315-513bd4ec-da4c-4fab-aa8a-721861d9cff0.png)

    * Fill in the title and provide a concise description.
        ![pic8](https://user-images.githubusercontent.com/69135897/135800336-3a00ca91-d219-4959-8a50-266930e44fa8.png)
    
11. Wait for respose on the PR. Congratulations you just contributed to open source!


## Code of conduct 👨‍💻
[CODE_OF_CONDUCT.md](https://github.com/ShivamYadav-Coding/hacktoberfest-2021/blob/main/CODE_OF_CONDUCT.md)

## Labels 🏷

__Issues labelled with language name e.g Python, mean that the particular issue has been assigned for language in the label__

## Let's connect

<a href="https://www.linkedin.com/in/shivam-yadav-89ab6519a/"><img src="https://hackernoon.com/images/PrB8ElNwFUY9FJD7Kw2aUJtm1UW2-cjw12i45.gif" align="left" height="52" width="52" ></a>
