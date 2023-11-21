export default (state, action) => {
  switch(action.type) {
    case 'DELETE_EXPENSE':
      return {
        ...state,
        expense: {
          ...state.expense,
          membersList: state.expense.membersList.map(member => {
            if (member.id === state.memberID) { // Assuming you want to delete from the member with ID 1
              return {
                ...member,
                transactions: member.transactions.filter(transaction => transaction.id !== action.payload)
              };
            }
            return member;
          })
        }
      };
    case 'ADD_EXPENSE':
      state.expense.membersList.find(m => m.id === state.memberID).transactions.push(action.payload)
      return {
        ...state,
        expense: state.expense
      };

    case 'MODIFY_EDITOR':
      return {
        ...state,
        memberID: action.payload
      }
    case 'FETCH_SUCCESS':
      const memID = action.payload.membersList[0].id;
      //console.log("payload called with id: " + memID + " Data: " + action.payload)
      return {
        ...state,
        expense: action.payload,
        memberID: memID
      };
    default:
      return state;
  }
}