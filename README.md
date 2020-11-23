# Earth Speaks

A [philly codefest](https://philly-codefest-2020.devpost.com/) submission made by:

- [Maciej Lewicki](https://github.com/mlewicki12)
- [Jackie Ni](https://github.com/jackie-ni)
- [Torin Rittenhouse](https://github.com/torin99r)
- [Samuel Tate](https://github.com/samuel-tate)

## Background

When brainstorming ideas for this hackathon, all of us kept coming to the same frustrating conclusion: 
sometimes it can feel like we have no way to meaningfully make a positive impact on the environment. 

We all recycle, we all take public transportation as much as possible, and some of us have completely cut meat out of our diet because of the harm that meat farming cuases to the environment.  

We all felt like we are doing as much as we can, but still, year after year, new articles keep coming out saying that the environment isn't improving and we're running out of time.

We realized that the biggest problem for the environment probably wasn't realated to us, instead it was related to the massive corporations that cared more about profits than their impact on the environment.

We also realized that we felt as though we had no way to change this. It seemed like the best way to change how corperations impacted the environment was through government regulations, but none of us how where to start when it came to getting in touch with our local government representatives.

That's where we saw Earth Speaks coming into play.

Earth Speaks is a platform where users can create `issues` related to the environment, or any other problems that they feel are important.
These `issues` describe a problem and offer a call to action to politicians to solve this problem.
Other users can browse these issues and easily send them to their local representatives. 
Earth Speaks offers an easy way for people to have their voices heard related to the issues that they feel are most important.

## What We've Accomplished

So far we've created a baseline for Earth Speaks. This baseline consists of an android app and a backend RESTful API.

The android app allows users to browse `issues` and create new ones.

The API is able to support all actions related to creating and getting `issues`. It also supports getting info related to government representatives based on zip code.

The code related to the android app can be found in this repo.

The code related to the API can be found [here](https://github.com/samuel-tate/environmental-codefest-api).

## Future Plans

In the future we plan to support user accounts.
User accounts will hold all the info related to the user's government officials based on their zip code so that `issues` can be sent to them with a single button press.
