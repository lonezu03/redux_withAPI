import './App.css'
import {Fetchcompany} from './component/redux/companySlice.jsx'
import {useDispatch,useSelector} from 'react-redux'
import { useEffect } from 'react'
import {company} from './component/redux/selection.jsx'
import Company from './component/entity/company.jsx'
//import Company from './component/entity/company.jsx'
function App() {
  const dipatch=useDispatch()
  useEffect(()=>{
  dipatch(Fetchcompany())},[])
  const cmpany = useSelector(company);
  console.log(cmpany)
  return (
    <>
      <div>
<Company></Company>

        </div>
    </>
  )
}

export default App
