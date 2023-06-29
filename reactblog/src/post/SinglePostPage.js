import { useSelector } from 'react-redux'
import { selectPostById } from './postsSlice'
import TimeAgo from "./TimeAgo";
import ReactionButtons from "./ReactionButtons";
import Button from 'react-bootstrap/Button';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import Base from '../Base';
import { deletePost } from "./postsSlice";

import { useNavigate } from 'react-router-dom'

const SinglePostPage = () => {
    const { postId } = useParams()
    const navigate = useNavigate()
    const dispatch = useDispatch()

    const post = useSelector((state) => selectPostById(state, Number(postId)))

    if (!post) {
        return (
            <section>
                <h2>Post not found!</h2>
            </section>
        )
    }
    const deletepos = (e) => {
        try {
         
            dispatch(deletePost({ id: e })).unwrap()
            navigate('/')
        } catch (err) {
            console.error('Failed to delete the post', err)
        } finally {
            console.error('post  deleted  ')
        }
    }
    return (
        <Base>
        <article>
             <div id='cenn'>
             <div class="card text-center">
  <div class="card-header">
    Post Details
  </div>
  <div id='like'>
           <ReactionButtons post={post} />
            </div>
  <div class="card-body">
    <h5 class="card-title">{post.title}</h5>
    <p class="card-text">{post.body}.</p>
    <Button variant="danger" id='del' ><i class="fa-solid fa-trash"
              onClick={
                ()=> deletepos(post.id)
             }
            >
                </i></Button>
    
    <Button variant="primary" id='penn'><Link to={`/post/edit/${post.id}`}><i class="fa-solid fa-pen">
          </i></Link></Button>
  </div>
  <div class="card-footer text-muted">
  <TimeAgo timestamp={post.date} />
  </div>
</div>
             </div>
        </article>
        </Base>
    )
}

export default SinglePostPage