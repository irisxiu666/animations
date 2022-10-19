# Easy Animation
author: Tingting Xiu

email: xiu.t@northeastern.edu

## Project introduction


Easy Animation is the final project for course CS5004 Object-Oriented Design in Northeastern University of 2022 summer semester. 
The goal of this project is to create simple but effective 2D animations from shapes. 


Basic functions of this project is to show animations in textual, visual and SVG formats. Advanced
function enables users to operate animations include pause,resume,restart, and loop animations.


Tech stack:
- Java Swing
- MVC design pattern


## Concrete Design

The whole project contains four parts: model,view,controller and test.

### Model
The main model of this project is called Document, which is to store growing animation information.
Shape and Animation are like helper classes to establish the main model. In detail,
Shape and Animation are components of Document. Shape stores the state of shapes in a specific tick, while Animation stores the start state and the end state of
animations. With the help of these two classes, we can access animation states of every tick in the Document,
so that we can show them continuously.

### View

This part includes View interface mainly, and TextualView, SVGView, VisualView, 
EditableView all implements from it. These views enable users to see animations differently in textual, SVG, visual
formats. 

### Controller

This part is to connect the whole project. Controller parses commands from users, 
and pass the Document model to specific view, then the view is to show the animations.


### Test

This part is to test the whole project thoroughly. For some functions, we can only visually test them.



