import React from 'react';
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import Base from "../Base";
import { Card, CardBody, Form, Input, Label, Button, Container } from "reactstrap"
import JoditEditor from "jodit-react"
import { useRef } from "react"
import { useState } from "react";
import { updatePost,selectPostById,reset } from './postsSlice';
import { useParams} from 'react-router-dom'



const EditPostForm = () => {
    const editor = useRef(null)
    const dispatch = useDispatch()
    const { postId } = useParams()
    const navigate = useNavigate()
    const post = useSelector((state) => selectPostById(state, Number(postId)))
  

    const [title, setTitle] = useState(post?.title)
    const [content, setContent] = useState(post?.body)
    const [requestStatus, setRequestStatus] = useState('idle')

  

    if (!post) {
        return (
            <section>
                <h2>Post not found!</h2>
            </section>
        )
    }

    const onTitleChanged = e => setTitle(e.target.value)
    const onContentChanged = e => {
        let a = e.replace( /(<([^>]+)>)/ig, '')
        console.log(a)
        setContent(a)
    }
   

    const canSave = [title, content].every(Boolean) && requestStatus === 'idle';

    const onSavePostClicked = () => {
        if (canSave) {
            try {
                setRequestStatus('pending')
                dispatch(updatePost({ id: post.id, title, body: content,  reactions: post.reactions })).unwrap()

                setTitle('')
                setContent('')
               
                navigate(`/post/${postId}`)
            } catch (err) {
                console.error('Failed to save the post', err)
            } finally {
                setRequestStatus('idle')
            }
        }
    }
    const resetAll = () => {
        setTitle("");
        setContent("");
        dispatch(reset());
    }

    

  return (
    <section>
          
            <Base>
        <div className="wrapper">
            <Card className="shadow-sm  border-0 mt-2">
    <CardBody>
               
                 <h3>What going in your mind ?</h3>
                <Form >
                       <div className="my-3">
                           <Label for="title" >Post title</Label>
                           <Input
                               type="text"
                               id="postTitle"
                               name="postTitle"
                               value={title}
                               onChange={onTitleChanged}
                               
                            />
                          
                        </div>

                        <div className="my-3">
                        
                            <Label for="content" >Post Content</Label>
                            
                            <JoditEditor
                                ref={editor}
                                value={content}
                                onChange={(a) => onContentChanged(a)}
                                
                            />
                     
                       
                        </div>


                      

                        <Container className="text-center">
                            <Button type="submit" className="rounded-0" color="primary" onClick={onSavePostClicked}
                    disabled={!canSave}>Update Post</Button>
                            <Button onClick={resetAll} className="rounded-0 ms-2" color="danger">Reset Content</Button>
                        </Container>


                    </Form>


                </CardBody>

            </Card>




        </div>
        </Base>
        </section>
  )
}
export default EditPostForm
