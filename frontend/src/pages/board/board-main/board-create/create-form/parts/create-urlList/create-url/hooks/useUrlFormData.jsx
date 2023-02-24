/* 사용하지 않음. */
// import { useEffect, useState } from 'react';

// function useUrlFormData() {
//   const url = {
//     address: '',
//     category: '',
//   };

//   const Action_Map = {
//     ADD: 'add',
//     DELETE: 'delete',
//     RECENT_DELETE: 'pop',
//   };

//   const [urls, setUrls] = useState([]);

//   const handleUrlData = (action, data, targetIndex) => {
//     if (action === 'add') {
//       setUrls((prevList) => [...prevList, data === null ? url : data]);
//     } else if (action === 'delete') {
//       //   setUrls((prevList) => Array.from(prevList).filter((value) => value.indexof() !== targetIndex));
//     } else if (action === 'pop') {
//       setUrls((prevList) => prevList.slice(0, -1));
//     }
//   };

//   return {
//     urls,
//     Action_Map,
//     handleUrlData,
//   };
// }

// export default useUrlFormData;
